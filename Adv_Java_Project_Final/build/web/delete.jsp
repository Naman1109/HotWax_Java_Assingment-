<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="Styles/style2.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script>
            const validateEmail = (email) => {
                return email.match(
                        /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
                        );
            };

            const validate = () => {
//  const $result = $('#result');
                const email = $('#email').val();
//  $result.text('');

                if (validateEmail(email)) {
                    $email.text(email + ' is valid :)');
                    $email.css('color', 'green');
                } else {
                    $email.text(email + ' is not valid :(');
                    $email.css('color', 'red');
                }
                return false;
            }

            $('#email').on('input', validate);

        </script>
    </head>
    <body>
        <!--fname,lname,email,address,city,state,country,zip,phone,password-->

        <div class="container">
            <div class="title">Delete User</div>
            <div class="content">
                <form action="delete">
                    <div class="user-details">
                        <div class="input-box">
                            <span class="details">Email</span>
                            <input id="email" type="text" name="email" placeholder=" Email" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Password</span>
                            <input type="password" name="password" placeholder="Password" required>
                        </div>
                    </div>
                    <div class="button">
                        <input type="submit" value="Delete">
                    </div>
                </form>
            </div>
        </div>

    </body>
</html>
