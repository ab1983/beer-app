$(document).ready(function () {
	
	// Add a onClick event to the nextRandom button.
    $("#btn-nextRandom").click(function (event) {

        event.preventDefault();

        nextRandom();

    });
    // It shows a new beer when the page is loaded at the fist time.
    nextRandom();

});

/**
 * Function to call the API and find the next random beer. After getting the response success, 
 * a new beer is displayed in the main page.
 * @returns
 */
function nextRandom() {

    $("#btn-nextRandom").prop("disabled", true);

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/beer-app/api/beer/next-random",
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            $('#name').html(data.name);
            $('#description').html(data.description);
            $('#abv').html(data.abv);
            $('#location').html(data.location);

            console.log("SUCCESS : ", data);
            $("#btn-nextRandom").prop("disabled", false);

        },
        error: function (e) {

        	alert(JSON.stringify(JSON.parse(e.responseText).message));
            console.log("ERROR : ", e);
            $("#btn-nextRandom").prop("disabled", false);

        }
    });

}