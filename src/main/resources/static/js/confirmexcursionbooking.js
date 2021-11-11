// $(window).on('load', function() {
//
//
//     document.forms['booking_form'].addEventListener('submit', (event) => {
//         event.preventDefault();
//
//         Swal.fire({
//             title: 'Are you sure you want to book?',
//             icon: 'warning',
//             showCancelButton: true,
//             confirmButtonColor: '#3085d6',
//             cancelButtonColor: '#d33',
//             confirmButtonText: 'Yes, book it!'
//         }).then((result) => {
//             if (result.isConfirmed) {
//                 fetch(event.target.action, {
//                     method: 'POST',
//                     redirect: 'follow',
//                     body: new URLSearchParams(new FormData(event.target)) // event.target is the form
//                 }).then((resp) => {
//                     if (resp.redirected) {
//                         window.location.href = resp.url;
//                     }
//                     return resp.json(); // or resp.text() or whatever the server sends
//                 })
//             }
//         });
//
//     });
//
//
// });
