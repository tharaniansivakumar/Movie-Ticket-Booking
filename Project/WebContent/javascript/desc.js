function getMovies() {
    var params = {
        url: "customerscreen",
        success: function (data) {
        	console.log(data);
            var movieDetails = JSON.parse(data);
            console.log(movieDetails);
        				var d=new Date();
        				var a=d.getMonth();
        				var b=d.getDate();
			                if(a==2){
			            	var c="mar";}

            var template =  '<div class="movie-desc">\
            					<form  action="showadd" method="GET"><div style="padding-bottom:10px">\
            					<div id="s">\
            							<img src="*thumb*" width="60%" height="40%"><br>\
            							<p style="color:yellow">*movie-name*</p><br>\
            							<p>*screen*</p>\
                                </div>\
                                <div class="btn-group" data-toggle="buttons">\
						            	<select class="btn btn-success" name="date">\
						    			<option value="*nxtdate*">*currentdate*</option>\
						    			<option value="*curtdate*">*nextdate*</option>\
						    		</select>\
            						</div>\
            						<div style="padding-left:20px;padding-right:20px" class="btn-group" data-toggle="buttons">\
						            	<select class="btn btn-success" name="time">\
						    			<option value="10am">10am</option>\
						    			<option value="2pm">2pm</option>\
						    			<option value="7pm">7pm</option>\
						    			<option value="10pm">10pm</option>\
						    		</select>\
            						</div>\
            						<input type="submit" value="Book" class="btn btn-success" />\
                                </div>\
                            </div>\
                        </form>\
                </div>';
            var tamilResult ="" ;
            		console.log(movieDetails.length)
                   tamilResult += template.replace("*thumb*",
                        movieDetails.url).replace("*movie-name*", movieDetails.movieName).replace("*screen*", movieDetails.screenNo).replace("*currentdate*",b+c).replace("*nextdate*",b+1+c).replace("*nxtdate*",b+1+c).replace("*curtdate*",b+c);
                    console.log(movieDetails.screen);
            document.getElementById("movie-desc").innerHTML = tamilResult;
        }
    }
    $.ajax(params);
}
window.onload = getMovies();