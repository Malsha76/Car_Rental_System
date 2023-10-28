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
})