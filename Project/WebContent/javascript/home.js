function getMovies() {
            var template ='<li class="row row--1">\
      <ol class="seats" type="A">\
        <li class=".one">\
          <input type="checkbox" name="names" value="*t1*A" />\
          <label for="*t21*">*t2*A</label>\
        </li>\
        <li class=".one">\
          <input type="checkbox" name="names" value="*t3*B" />\
          <label for="*t22*">*t4*B</label>\
        </li>\
        <li class=".one">\
          <input type="checkbox" name="names" value="*t5*C" />\
          <label for="*t23*">*t6*C</label>\
        </li>\
        <li class=".one">\
          <input type="checkbox" name="names" value="*t7*D" />\
          <label for="*t24*">*t8*D</label>\
        </li>\
        <li class=".one"  style="margin-right: 14.28571428571429%;">\
          <input type="checkbox" name="names" value="*t9*E" />\
          <label for="*t25*">*t10*E</label>\
        </li>\
        <li class=".one" >\
          <input type="checkbox" name="names" value="*t11*F" />\
          <label for="*t26*">*t12*F</label>\
        </li>\
        <li class=".one">\
          <input type="checkbox" name="names" value="*t13*G" />\
          <label for="*t27*">*t14*G</label>\
        </li>\
        <li class=".one">\
          <input type="checkbox" name="names" value="*t15*H" />\
          <label for="*t28*">*t16*H</label>\
        </li>\
        <li class=".one">\
          <input type="checkbox" name="names" value="*t17*I" />\
          <label for="*t29*">*t18*I</label>\
        </li>\
        <li class=".one">\
          <input type="checkbox" name="names" value="*t19*J" />\
          <label for="*t30*">*t20*J</label>\
        </li>\
      </ol>\
    </li>';
            var tamilResult ="" ;
            for (var i = 1; i <=10; i++) {
                   
                   tamilResult += template.replace("*t1*",i).replace("*t2*",i).replace("*t3*",i).replace("*t4*",i).replace("*t5*",i).replace("*t6*",i).replace("*t7*",i).replace("*t8*",i).replace("*t9*",i).replace("*t10*",i).replace("*t11*",i).replace("*t12*",i).replace("*t13*",i).replace("*t14*",i).replace("*t15*",i).replace("*t16*",i).replace("*t17*",i).replace("*t18*",i).replace("*t19*",i).replace("*t20*",i).replace("*t21*",i).replace("*t22*",i).replace("*t23*",i).replace("*t24*",i).replace("*t25*",i).replace("*t26*",i).replace("*t27*",i).replace("*t28*",i).replace("*t29*",i).replace("*t30*",i); 
        }
        document.getElementById("replace").innerHTML = tamilResult;
}
window.onload = getMovies();