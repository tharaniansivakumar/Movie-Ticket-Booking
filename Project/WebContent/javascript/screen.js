function getMovies() {
    var params = {
        url: "listmovie",
        success: function (data) {
        	console.log(data);
            var movieDetails = JSON.parse(data);
            var template = '<div class="movie-screen">\
            					<form  action="screenadd" method="Get"><div style="padding-bottom:10px">\
            					<div id="s">\
            							<img src="*thumb*" width="70%" height="40%"><br>\
            							<p style="color:yellow">*movie-name*</p>\
            							<p>*screen*</p>\
                                  </div>\
            						<input style="display:none;" type="text" value="*temp*" name="val" />\
            						<input style="width: 150px;height: 50px;" type="submit" value="Book" class="btn btn-success" />\
                                </div>\
                            </div>\
                        </form>\
                </div>';
            var tamilResult ="" ;
            for (var i = 0; i < movieDetails.length; i++) {
                   tamilResult += template.replace("*thumb*",
                        movieDetails[i].Url).replace("*movie-name*",movieDetails[i].movieName).replace("*temp*",movieDetails[i].screen).replace("*screen*", movieDetails[i].screen);
        }
           // console.log(tamilResult);
            document.getElementById("movie-screen").innerHTML = tamilResult;
        }
    }
    $.ajax(params);
}
window.onload = getMovies();