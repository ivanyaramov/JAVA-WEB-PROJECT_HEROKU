$(window).on('load', function() {
    var townsandcountries;


    fetch('/rest/townsandcountries', {
        method: 'GET', // or 'PUT'
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(townsandcountries),
    })
        .then(response => response.json())
        .then(townsandcountries => {
            console.log('Success:', townsandcountries);
            for(var i=0;i<townsandcountries.length;i++){
                var town = townsandcountries[i].split("id:")[0];
                var id = townsandcountries[i].split("id:")[1];
                $option = $('<option value = \'' + id+ '\'>' + town+ '</option>')
                $("#townsandcountries").append( $option ); 
            }
        })
        .catch((error) => {
            console.error('Error:', error);
        });



    $(document).on("click","#buttonlistener",
    function() {
        console.log($("#searchbar").val());
        var id = $("#searchbar").val();
        if ($("#searchbar").val() !== "" && !isNaN(id)) {
            window.location.href = "/towns/info/" + id;
        }
    });





}
);


