// Username không được trống, tối thiểu 3 ký tự, không chứa ký tự đặc biệt
// Mật khẩu không được trống, tối thiểu 8 ký tự

$(document).ready(function () {
    $('#username').on('focusout', function () {
        if ($('#username').val() != "") {
            if (validateUserName($('#username').val())) {
                $('.error1').fadeOut('slow');
            } else {
                $('.error1').text('Tên tài khoản không được chưa ký tự đặc biệt!');
                $('.error1').fadeIn('slow');
            }

            if (validateUserNameTwo($('#username').val())) {
                $('.error1').fadeOut('slow');
            } else {
                $('.error1').text('Tên tài khoản tối thiểu 3 ký tự!');
                $('.error1').fadeIn('slow');
            }
        } else {
            $('.error1').text('Tên tài khoản không được để trống!');
            $('.error1').fadeIn("slow");
        }
    });
});
$(document).ready(function () {
    $('#password').on('focusout', function () {
        if ($('#password').val() != "") {
            if (validatePassword($('#password').val())) {
                $('.error2').fadeOut('slow');
            } else {
                $('.error2').text('Mật khẩu tối thiểu 8 ký tự!');
                $('.error2').fadeIn('slow');
            }
        } else {
            $('.error2').text('Mật khẩu không được để trống!');
            $('.error2').fadeIn("slow");
        }
    });
});


function validateUserName(eVal) {
    var val = /(^[a-zA-Z0-9]*)$/;
    if (val.test(eVal)) {
        return true;
    } else {
        return false;
    }
}
function validateUserNameTwo() {
    const usernameEle = document.getElementById('username');
    let usernameValue = usernameEle.value;
    if (usernameValue.length >= 3) {
        return true;
    } else {
        return false;
    }
}

function validatePassword() {
    const passwordEle = document.getElementById('password');
    let passwordValue = passwordEle.value;
    if (passwordValue.length >= 8) {
        return true;
    } else {
        return false;
    }
}



