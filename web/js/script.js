var index = 0;
fungsi();

function fungsi(){
    var i;
    var slide = document.getElementsByClassName('hero-slider');

    for(i=0;i<slide.length; i++){
        slide[i].style.display = 'none';
    }

    index++
    if(index > slide.length){
        index=1;
    }

    slide[index-1].style.display = "block";
    setTimeout(fungsi, 4000);
}
