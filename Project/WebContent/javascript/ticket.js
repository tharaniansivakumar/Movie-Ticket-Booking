function getMovies() {
    var params = {
        url: "ticket",
        success: function (data) {
        	console.log(data);
            var movieDetails = JSON.parse(data);
            console.log(movieDetails);
            var template = '<div class="movie-screen">\
                      					<div id="s">\
                                        <p>TicketId:TICID*ticketid*</p>\
                                        <p>Email:*email*</p>\
            							<p style="color:yellow">MovieName:*movie-name*</p>\
            							<p>*screen*</p>\
                                        <p>Date:*date*</p>\
                                        <p>Time:*time*</p>\
                                        <p>seatno:*seatno*</p>\
                                        <p>Tickets:*seat*</p>\
                                        <p>price:*price*</p>\
                                  </div>\
                                </div>\
                </div>';
            var tamilResult ="" ;
            var n,i;
            	n=movieDetails.length;
            	i=n-1;
         	
                   tamilResult += template.replace("*ticketid*",movieDetails[i].customerId).replace("*email*",movieDetails[i].email).replace("*movie-name*",
                        movieDetails[i].movieName).replace("*screen*",movieDetails[i].screenNo).replace("*date*",movieDetails[i].date).replace("*time*", movieDetails[i].showTime).replace("*seatno*",movieDetails[i].seatNo).replace("*seat*",movieDetails[i].noOfSeat).replace("*price*",movieDetails[i].price);
            		
     
           // console.log(tamilResult);
            document.getElementById("ticket").innerHTML = tamilResult;
        }
    }
    $.ajax(params);
}
window.onload = getMovies();