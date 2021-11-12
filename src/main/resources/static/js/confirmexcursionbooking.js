$(window).on('load', function() {

    var price;

    document.forms['booking_form'].addEventListener('submit', (event) => {
        event.preventDefault();

        var countAdults = $("#countofadults").val();
        var countChildren = $("#countofchildren").val();

        var priceData = {'countOfAdults': countAdults, 'countOfChildren': countChildren };
        var formBody = [];
        for (var property in priceData) {
            var encodedKey = encodeURIComponent(property);
            var encodedValue = encodeURIComponent(priceData[property]);
            formBody.push(encodedKey + "=" + encodedValue);
        }
        formBody = formBody.join("&");

        fetch('/rest/bookingexcursionprice', {
            method: 'POST',
            redirect: 'follow',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
            },
            body: formBody
        }).then((resp) => {
            if (resp.redirected) {
                window.location.href = resp.url;
            }
            return resp.json(); // or resp.text() or whatever the server sends
        }).then((body) => {
            price = body;
            Swal.fire({
                title: 'Are you sure you want to book?',
                text: 'Price: ' + price + ' leva',
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, book it!'
            }).then((result) => {
                if (result.isConfirmed) {
                    fetch(event.target.action, {
                        method: 'POST',
                        redirect: 'follow',
                        body: new URLSearchParams(new FormData(event.target)) // event.target is the form
                    }).then((resp) => {
                        if (resp.redirected) {
                            window.location.href = resp.url;
                        }
                        return resp.json(); // or resp.text() or whatever the server sends
                    })
                }
            });

        }).catch((error) => {
            Swal.fire({
                icon: 'error',
                title: 'Server error',
                text: 'Something went wrong!',
            })
            window.location.href = "/"
        });


    });


});
