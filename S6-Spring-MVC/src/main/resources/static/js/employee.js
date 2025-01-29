console.log("Employee JavaScript file")

$(document).ready(function () {
    $('#myForm').on('submit', function (e) {
        e.preventDefault(); // Prevent the default form submission
        console.log("Submitted ")
        Swal.fire({
            title: 'Please wait...',
            text: 'Submitting your registration...',
            allowOutsideClick: false,
            didOpen: () => {
                Swal.showLoading();
            }
        });
        // Gather form data
        const formData = $(this).serialize();

        // Perform AJAX call
        $.ajax({
            url: '/employees/save',  // Replace with your server endpoint
            method: 'POST',       // HTTP method
            data: formData,       // Serialized form data
            success: function (response) {
                // Handle success
                $("#myForm")[0].reset();
                console.log("Checkout submitted")
                Swal.fire({
                    title: 'Thank you for registering your interest!',
                    text: 'A member of our team will be in touch with you shortly. Please keep an eye out for updates and notifications in your email.',
                    icon: 'success',
                    confirmButtonText: 'OK'
                });
                $('#formModal').modal('hide'); // Hide the modal
            },
            error: function () {
                // Handle error
                console.log(this.error)
                Swal.fire({
                    title: 'Error!',
                    text: 'There was an issue with your registration.',
                    icon: 'error',
                    confirmButtonText: 'OK'
                });
            }
        });
    });
});


new DataTable('#employee', {
    layout: {
        bottomEnd: {
            paging: {
                firstLast: false
            }
        }
    }
});
