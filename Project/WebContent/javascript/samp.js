function getMovies() {
    var params = {
        url: "seatadmin",
        success: function (data) {
        	console.log(data);
            var movieDetails = JSON.parse(data);
            console.log(movieDetails);
            var template = '<li class="row row--1">\
      <ol class="seats" type="A">\
        <li class=".one">\
          <input *dis1* type="checkbox" name="names" value="1*t1*" />\
          <label for="1*t21*">1*t2*</label>\
        </li>\
        <li class=".one">\
          <input *dis2* type="checkbox" name="names" value="2*t3*" />\
          <label for="2*t22*">2*t4*</label>\
        </li>\
        <li class=".one">\
          <input *dis3* type="checkbox" name="names" value="3*t5*" />\
          <label for="3*t23*">3*t6*</label>\
        </li>\
        <li class=".one">\
          <input *dis4* type="checkbox" name="names" value="4*t7*" />\
          <label for="4*t24*">4*t8*</label>\
        </li>\
        <li class=".one"  style="margin-right: 14.28571428571429%;">\
          <input *dis5* type="checkbox" name="names" value="5*t9*" />\
          <label for="5*t25*">5*t10*</label>\
        </li>\
        <li class=".one" >\
          <input *dis6* type="checkbox" name="names" value="6*t11*" />\
          <label for="6*t26*">6*t12*</label>\
        </li>\
        <li class=".one">\
          <input *dis7* type="checkbox" name="names" value="7*t13*" />\
          <label for="*7t27*">7*t14*</label>\
        </li>\
        <li class=".one">\
          <input *dis8* type="checkbox" name="names" value="8*t15*" />\
          <label for="8*t28*">8*t16*</label>\
        </li>\
        <li class=".one">\
          <input *dis9* type="checkbox" name="names" value="9*t17*" />\
          <label for="9*t29*">9*t18*</label>\
        </li>\
        <li class=".one">\
          <input *dis10* type="checkbox" name="names" value="10*t19*" />\
          <label for="10*t30*">10*t20*</label>\
        </li>\
    </ol>\
    </li>';
            var tamilResult ="" ;
            for (var i = 0; i <3; i++) {
                var temp = ""; 
                var st="checked='checked' disabled readonly"
                temp += template.replace("*t1*",String.fromCharCode(65+i)).replace("*t2*",String.fromCharCode(65+i)).replace("*t3*",String.fromCharCode(65+i)).replace("*t4*",String.fromCharCode(65+i)).replace("*t5*",String.fromCharCode(65+i)).replace("*t6*",String.fromCharCode(65+i)).replace("*t7*",String.fromCharCode(65+i)).replace("*t8*",String.fromCharCode(65+i)).replace("*t9*",String.fromCharCode(65+i)).replace("*t10*",String.fromCharCode(65+i)).replace("*t11*",String.fromCharCode(65+i)).replace("*t12*",String.fromCharCode(65+i)).replace("*t13*",String.fromCharCode(65+i)).replace("*t14*",String.fromCharCode(65+i)).replace("*t15*",String.fromCharCode(65+i)).replace("*t16*",String.fromCharCode(65+i)).replace("*t17*",String.fromCharCode(65+i)).replace("*t18*",String.fromCharCode(65+i)).replace("*t19*",String.fromCharCode(65+i)).replace("*t20*",String.fromCharCode(65+i)).replace("*t21*",String.fromCharCode(65+i)).replace("*t22*",String.fromCharCode(65+i)).replace("*t23*",String.fromCharCode(65+i)).replace("*t24*",String.fromCharCode(65+i)).replace("*t25*",String.fromCharCode(65+i)).replace("*t26*",String.fromCharCode(65+i)).replace("*t27*",String.fromCharCode(65+i)).replace("*t28*",String.fromCharCode(65+i)).replace("*t29*",String.fromCharCode(65+i)).replace("*t30*",String.fromCharCode(65+i)); 
                for(var j = 0; j < 10; j++){
                    if (movieDetails.includes((j+1)+String.fromCharCode(65+i)) ){
                        //console.log("a"+movieDetails[j]);
                        temp = temp.replace("*dis"+(j+1)+"*",st);
                        //console.log(temp)
                    }
                }
                tamilResult+= temp;
            }
           // console.log(tamilResult);
            document.getElementById("replace").innerHTML = tamilResult;
    
    
    
    var template = '<li class="row row--1">\
        <ol class="seats" type="A">\
          <li class=".one">\
            <input *dis1* type="checkbox" name="names" value="1*t1*" />\
            <label for="1*t21*">1*t2*</label>\
          </li>\
          <li class=".one">\
            <input *dis2* type="checkbox" name="names" value="2*t3*" />\
            <label for="2*t22*">2*t4*</label>\
          </li>\
          <li class=".one">\
            <input *dis3* type="checkbox" name="names" value="3*t5*" />\
            <label for="3*t23*">3*t6*</label>\
          </li>\
          <li class=".one">\
            <input *dis4* type="checkbox" name="names" value="4*t7*" />\
            <label for="4*t24*">4*t8*</label>\
          </li>\
          <li class=".one"  style="margin-right: 14.28571428571429%;">\
            <input *dis5* type="checkbox" name="names" value="5*t9*" />\
            <label for="5*t25*">5*t10*</label>\
          </li>\
          <li class=".one" >\
            <input *dis6* type="checkbox" name="names" value="6*t11*" />\
            <label for="6*t26*">6*t12*</label>\
          </li>\
          <li class=".one">\
            <input *dis7* type="checkbox" name="names" value="7*t13*" />\
            <label for="*7t27*">7*t14*</label>\
          </li>\
          <li class=".one">\
            <input *dis8* type="checkbox" name="names" value="8*t15*" />\
            <label for="8*t28*">8*t16*</label>\
          </li>\
          <li class=".one">\
            <input *dis9* type="checkbox" name="names" value="9*t17*" />\
            <label for="9*t29*">9*t18*</label>\
          </li>\
          <li class=".one">\
            <input *dis10* type="checkbox" name="names" value="10*t19*" />\
            <label for="10*t30*">10*t20*</label>\
          </li>\
      </ol>\
      </li>';
              var tamilResult ="" ;
              for (var i = 3; i<7; i++) {
                  var temp = "";
                  var st="checked='checked' disabled readonly";
                  temp += template.replace("*t1*",String.fromCharCode(65+i)).replace("*t2*",String.fromCharCode(65+i)).replace("*t3*",String.fromCharCode(65+i)).replace("*t4*",String.fromCharCode(65+i)).replace("*t5*",String.fromCharCode(65+i)).replace("*t6*",String.fromCharCode(65+i)).replace("*t7*",String.fromCharCode(65+i)).replace("*t8*",String.fromCharCode(65+i)).replace("*t9*",String.fromCharCode(65+i)).replace("*t10*",String.fromCharCode(65+i)).replace("*t11*",String.fromCharCode(65+i)).replace("*t12*",String.fromCharCode(65+i)).replace("*t13*",String.fromCharCode(65+i)).replace("*t14*",String.fromCharCode(65+i)).replace("*t15*",String.fromCharCode(65+i)).replace("*t16*",String.fromCharCode(65+i)).replace("*t17*",String.fromCharCode(65+i)).replace("*t18*",String.fromCharCode(65+i)).replace("*t19*",String.fromCharCode(65+i)).replace("*t20*",String.fromCharCode(65+i)).replace("*t21*",String.fromCharCode(65+i)).replace("*t22*",String.fromCharCode(65+i)).replace("*t23*",String.fromCharCode(65+i)).replace("*t24*",String.fromCharCode(65+i)).replace("*t25*",String.fromCharCode(65+i)).replace("*t26*",String.fromCharCode(65+i)).replace("*t27*",String.fromCharCode(65+i)).replace("*t28*",String.fromCharCode(65+i)).replace("*t29*",String.fromCharCode(65+i)).replace("*t30*",String.fromCharCode(65+i)); 
                  for(var j = 0; j < 10; j++){
                      if (movieDetails.includes((j+1)+String.fromCharCode(65+i)) ){
                          //console.log("a"+movieDetails[j]);
                          temp = temp.replace("*dis"+(j+1)+"*",st);
                          //console.log(temp)
                      }
                  }
                  tamilResult+= temp;
              }
             // console.log(tamilResult);
              document.getElementById("replace2").innerHTML = tamilResult;
              
              
              
              var template = '<li class="row row--1">\
                  <ol class="seats" type="A">\
                    <li class=".one">\
                      <input *dis1* type="checkbox" name="names" value="1*t1*" />\
                      <label for="1*t21*">1*t2*</label>\
                    </li>\
                    <li class=".one">\
                      <input *dis2* type="checkbox" name="names" value="2*t3*" />\
                      <label for="2*t22*">2*t4*</label>\
                    </li>\
                    <li class=".one">\
                      <input *dis3* type="checkbox" name="names" value="3*t5*" />\
                      <label for="3*t23*">3*t6*</label>\
                    </li>\
                    <li class=".one">\
                      <input *dis4* type="checkbox" name="names" value="4*t7*" />\
                      <label for="4*t24*">4*t8*</label>\
                    </li>\
                    <li class=".one"  style="margin-right: 14.28571428571429%;">\
                      <input *dis5* type="checkbox" name="names" value="5*t9*" />\
                      <label for="5*t25*">5*t10*</label>\
                    </li>\
                    <li class=".one" >\
                      <input *dis6* type="checkbox" name="names" value="6*t11*" />\
                      <label for="6*t26*">6*t12*</label>\
                    </li>\
                    <li class=".one">\
                      <input *dis7* type="checkbox" name="names" value="7*t13*" />\
                      <label for="*7t27*">7*t14*</label>\
                    </li>\
                    <li class=".one">\
                      <input *dis8* type="checkbox" name="names" value="8*t15*" />\
                      <label for="8*t28*">8*t16*</label>\
                    </li>\
                    <li class=".one">\
                      <input *dis9* type="checkbox" name="names" value="9*t17*" />\
                      <label for="9*t29*">9*t18*</label>\
                    </li>\
                    <li class=".one">\
                      <input *dis10* type="checkbox" name="names" value="10*t19*" />\
                       <label for="10*t30*">10*t20*</label>\
                    </li>\
                </ol>\
                </li>';
                        var tamilResult ="" ;
                        for (var i = 7; i <10; i++) {
                            var temp = "";    
                            var st="checked='checked' disabled readonly";
                            temp += template.replace("*t1*",String.fromCharCode(65+i)).replace("*t2*",String.fromCharCode(65+i)).replace("*t3*",String.fromCharCode(65+i)).replace("*t4*",String.fromCharCode(65+i)).replace("*t5*",String.fromCharCode(65+i)).replace("*t6*",String.fromCharCode(65+i)).replace("*t7*",String.fromCharCode(65+i)).replace("*t8*",String.fromCharCode(65+i)).replace("*t9*",String.fromCharCode(65+i)).replace("*t10*",String.fromCharCode(65+i)).replace("*t11*",String.fromCharCode(65+i)).replace("*t12*",String.fromCharCode(65+i)).replace("*t13*",String.fromCharCode(65+i)).replace("*t14*",String.fromCharCode(65+i)).replace("*t15*",String.fromCharCode(65+i)).replace("*t16*",String.fromCharCode(65+i)).replace("*t17*",String.fromCharCode(65+i)).replace("*t18*",String.fromCharCode(65+i)).replace("*t19*",String.fromCharCode(65+i)).replace("*t20*",String.fromCharCode(65+i)).replace("*t21*",String.fromCharCode(65+i)).replace("*t22*",String.fromCharCode(65+i)).replace("*t23*",String.fromCharCode(65+i)).replace("*t24*",String.fromCharCode(65+i)).replace("*t25*",String.fromCharCode(65+i)).replace("*t26*",String.fromCharCode(65+i)).replace("*t27*",String.fromCharCode(65+i)).replace("*t28*",String.fromCharCode(65+i)).replace("*t29*",String.fromCharCode(65+i)).replace("*t30*",String.fromCharCode(65+i)); 
                            for(var j = 0; j < 10; j++){
                                if (movieDetails.includes((j+1)+String.fromCharCode(65+i)) ){
                                    //console.log("a"+movieDetails[j]);
                                    temp = temp.replace("*dis"+(j+1)+"*",st);
                                    //console.log(temp)
                                }
                            }
                            tamilResult+= temp;
                        }
                       // console.log(tamilResult);
                      document.getElementById("replace3").innerHTML = tamilResult;
                    }
          }

    $.ajax(params);
}
window.onload = getMovies();
