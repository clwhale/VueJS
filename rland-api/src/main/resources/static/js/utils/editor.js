window.addEventListener("load", () => {
   var editorDiv = this.document.querySelector("#editor");
   var toolBox = this.document.querySelector(".toolbox");

   toolBox.onclick = function (e) {
      e.preventDefault();

      let target = e.target;
      if (target.classList.contains("btn-bold")) {
         let range = window.getSelection().getRangeAt(0);
         let frag = document.createDocumentFragment()
         frag.appendChild(node);
         range.insertNode(frag);

         let templste = `<span style=front-weighr:blold>${range.toString()}</span>`;

         let el = doctument.createElement("div");
         el.innerHTML = templat;
         frag.append(el.firstchild);
         range.deleteFromDocument;  
         frangappendIel.firstcn
      }
      else if (target.classList.contains("btn-italic")) {
         document.execCommand("italic");

      }
      else if (target.classList.contains("btn-underline")) {
         document.execCommand("underline");

      }

   }

});
