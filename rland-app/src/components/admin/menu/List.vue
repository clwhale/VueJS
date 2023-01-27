<script>
import ConfirmButton from '../../ConfirmButton.vue';
import ConfirmDlg from '../../ConfirmDlg.vue';

export default {
    data() {
        return {
            menus: [{ id: 1, name: "아메리카노" }, { id: 2, name: "카페라떼" }, {}, {}],
            displayNone: 'd-none',
            hideRegform: true,
            showRegform: false,
            menu: { name: 'test', price: 0 },
            query: '',
            open: false,
            openDlg: false
        };
    },
    components: { ConfirmButton, ConfirmDlg },
    methods: {
        addMenuBtnClickHandler() {
            this.displayNone = '';
            this.hideRegform = !this.hideRegform;
            this.showRegform = !this.showRegform;
        },
        async fetchMenus() {
            const response = await fetch(`http://localhost:8080/menus?q=${this.query}`);
            const json = await response.json();
            this.menus = json;
            console.log(json);
        },
        async postMenus() {
            const response = await fetch(`http://localhost:8080/menus`, {
                method: 'POST',
                headers: {
                    Accept: 'application/json',
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(this.menu)
            });
            const json = await response.json();
            console.log(json);
            // this.fetchMenus();
        },
        dlgCloseHandler(e) {
            if (e.isOk)
                this.showRegform = false;
            console.log('------------------------------------');
            console.log("closed");
            console.log('------------------------------------');
        },
        createMenuHandler(e) {
            this.postMenus();
        }
    },
    // 속성
    computed: {
        ice() {
            return parseInt(this.menu.price) + 500;
        },
        aa() {
            return 0;
        }
    },
    // 함수
    watch: {
        query() {
            this.fetchMenus();
        }
    },
    beforeCreate() {
        console.log("beforeCreate");
    },
    created() {
        console.log("created");
    },
    beforeMount() {
        console.log("beforeMount");
    },
    mounted() {
        console.log("mounted");
        this.fetchMenus();
    },
    beforeUpdate() {
        console.log("beforeUpdate");
    },
    updated() {
        console.log("updated");
    },
    beforeUnmount() {
        console.log("beforeUnmount");
    },
    unmounted() {
        console.log("unmounted");
    },
}
</script>

<template>
    <section>
        <header class="search-header">
            <h1 class="text-title1-h1">알랜드 메뉴</h1>
            <form>
                <input type="text" v-model="query">
                <input type="submit" class="icon icon-find">
            </form>
        </header>

        <nav class="menu-category">
            <header class="d-flex">
                <h1 class="text-normal-bold">메뉴분류</h1>
                <div>
                    <a class="btn btn-mini bg-blue" href="">분류추가</a>
                </div>
            </header>
            <ul>
                <li class="menu-selected">
                    <a href="/menu/list">전체</a>
                </li>
                <li>
                    <a href="" :class="displayNone">커피음료</a>
                </li>
                <li>
                    <a href="">수제청</a>
                </li>
                <li>
                    <a href="">샌드위치</a>
                </li>
                <li>
                    <a href="">쿠키</a>
                </li>
            </ul>
        </nav>

        <section class="cart-section">
            <h1 class="d-none">장바구니</h1>
            <span class="text-title3">커피음료</span>
            <a class="btn btn-mini bg-blue" href="" @click.prevent="addMenuBtnClickHandler">메뉴추가</a>
        </section>


        <section class="menu-section">
            <h1 class="d-none">메뉴목록</h1>
            <div class="menu-list">
                <transition name="reg-form">
                    <section class="menu menu-reg-section border-bottom border-color-1" v-if="showRegform">
                        <form class="overflow-hidden">
                            <h1><input type="text" class="input w-75 w-100-md" name="titile" v-model="menu.name"
                                    placeholder="메뉴 이름을 입력하세요.">
                            </h1>
                            <div class="menu-img-box">
                                <img src="/image/product/blank-img.png" class="img-input">
                                <input type="file" class="d-none">
                            </div>
                            <div class="menu-price"><input class="w-75 w-50-md input ml-0 ml-1-md" type="text"
                                    v-model="menu.price" placeholder="가격을 입력하세요"> 원</div>
                            <div class="menu-option-list">
                                <span class="menu-option">
                                    <input class="menu-option-input" type="checkbox">
                                    <label>ICED</label>
                                    <input type="text" style="width=50px" v-model="ice">
                                </span>
                                <span class="menu-option ml-2">
                                    <input class="menu-option-input" type="checkbox">
                                    <label>Large</label>
                                </span>
                            </div>
                            <div class="menu-button-list">
                                <ConfirmButton aa="btn btn-line btn-round btn-size-1 btn-bd-blue rounded-0-md"
                                    value="취소" />
                                <confirm-button class="btn btn-line btn-round btn-size-1 btn-bd-blue rounded-0-md"
                                    value="취소" @onDlgClose="dlgCloseHandler">
                                    <span style="color: red;">정말 취소하시겠습니까?</span>
                                </confirm-button>
                                <input
                                    class="btn btn-fill btn-round rounded-0-md btn-size-1 btn-bd-blue btn-color-blue ml-1"
                                    type="submit" value="저장" @click.prevent="createMenuHandler">
                            </div>
                        </form>
                    </section>
                </transition>
                <section class="menu border-bottom border-color-1" v-for=" menus in menus">
                    <form class="">
                        <h1>{{ menus.name }}</h1>
                        <div class="menu-img-box">
                            <a href="detail.html"><img class="menu-img" src="/image/product/12.png"></a>
                        </div>
                        <div class="menu-price">4500 원</div>
                        <div class="menu-option-list">
                            <span class="menu-option">
                                <input class="menu-option-input" type="checkbox">
                                <label>ICED</label>
                            </span>
                            <span class="menu-option ml-2">
                                <input class="menu-option-input" type="checkbox">
                                <label>Large</label>
                            </span>
                        </div>
                        <div class="menu-button-list">
                            <input class="btn btn-line btn-round btn-size-1 rounded-0-md" type="submit" value="수정">
                            <input class="btn btn-fill btn-round rounded-0-md btn-size-1 ml-1" type="submit" value="삭제">

                            <!-- <input class="btn btn-fill btn-round rounded-0-md btn-size-1 ml-1" type="submit" value="삭제" 
                            @click.prevent="openDlg=true">
                            <ConfirmDlg v-if="openDlg" @clickOk="" @clickCancel=""/> -->

                        </div>
                    </form>
                </section>
            </div>
        </section>

        <div class="d-flex justify-content-center py-3">
            <a href="" class="btn btn-line btn-round w-100 w-50-md py-2">더보기(13+)</a>
        </div>

        <section class="new-menu menu-section-p">
            <h1 class="d-none">신메뉴 목록</h1>
            <!-- <ul>
                    <li>
                    </li>
                </ul>  -->
            <div class="list">
                <span>신규로 출시된 메뉴가 없습니다.</span>
            </div>
        </section>

    </section>
</template>

<style scoped>
@keyframes bound-in {
    from {
        transform: scale(0);
    }

    50% {
        transform: scale(1.25);
    }

    to {
        opacity: 1;
        transform: scale(1);
    }
}

.reg-form-enter-active {
    /* transition: opacity 0.5s ease; */
    animation: bound-in 0.5s;
}

.reg-form-leave-active {
    /* transition: opacity 0.5s ease; */
    animation: bound-in 0.5s reverse;
}

.reg-form-leave-to {
    opacity: 0;
}
</style>