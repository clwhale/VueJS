<script>
export default {
    props: ['class', 'value'],
    emits: ['onDlgClose'],
    data() {
        return {
            open: false
        }
    },
    methods: {
        okClickHandler(e) {
            e.isOk=true;
            this.open = false;
            this.$emit('onDlgClose', e);
        },
        cancelClickHandler(e) {
            e.isOk=false;
            this.open = false;
            this.$emit('onDlgClose', e);
        }
    }
}
</script>
<template>
    <input :class="class" type="submit" :value="value" @click.prevent="open = true">
    <teleport to="body">
        <section v-if="open" class="modal-screen">
            <h1>대화상자</h1>
            <div class="modal-content">
                <p>
                    <slot />
                </p>
                <button @click="okClickHandler">예</button>
                <button @click="cancelClickHandler">아니요</button>
            </div>
        </section>
    </teleport>
</template>

<style scoped>
.modal-screen {
    position: fixed;
    left: 0;
    top: 0;
    width: 100vw;
    height: 100vh;

    background-color: rgba(0, 0, 0, 0.671);
}

.modal-content {
    position: fixed;
    left: 50vw;
    top: 30vh;
    width: 300px;
    margin-left: -150px;

    background-color: #fff;
    border: 1px solid #000;
    border-radius: 5px;
    padding: 20px;
}
</style>