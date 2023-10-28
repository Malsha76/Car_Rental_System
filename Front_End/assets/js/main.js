/**
 * @author: Malsha Ekanayake
 */
document.addEventListener('DOMContentLoaded',() => {
    "use strict";

    // preloader

    const preloader = document.querySelector('#preloader');
    if(preloader){
        window.addEventListener('load',() => {
            preloader.remove();
        });
    }

    // sticky header scroll

    const selectHeader = document.querySelector('#header');
      if (selectHeader){
          document.addEventListener('scroll',() =>{
              window.scrollY > 100 ? selectHeader.classList.add('sticked') :
                  selectHeader.classList.remove('sticked');
          });
    }
})