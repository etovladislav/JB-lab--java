
$(document).ready(function () {
    var jVal = {
        'val1': function () {
            if ($('#val1').attr('disabled') == 0) {
                var ele = $('#val1');
                var suc = $('#success');
                var formem = $('#form-val1');
                var pos = ele.offset();
                var patt = /^(\-?\d+(\.\d+)?)$/i;
                if (!patt.test(ele.val())) {
                    jVal.errors = true;
                    formem.removeClass().addClass('form-group has-error has-feedback');
                    suc.removeClass().addClass('glyphicon glyphicon-remove form-control-feedback');
                } else {
                    formem.removeClass().addClass('form-group has-success has-feedback');
                    suc.removeClass().addClass('glyphicon glyphicon-ok form-control-feedback');
                }
            }
        },
        'val2': function () {
            var suc1 = $('#success1');
            var formem1 = $('#form-val2');
            var ele = $('#val2');
            var pos = ele.offset();
            var patt = /^(\-?\d+(\.\d+)?)$/i;
            if (!patt.test(ele.val())) {
                jVal.errors = true;
                formem1.removeClass().addClass('form-group has-error has-feedback');
                suc1.removeClass().addClass('glyphicon glyphicon-remove form-control-feedback');
            } else {
                formem1.removeClass().addClass('form-group has-success has-feedback');
                suc1.removeClass().addClass('glyphicon glyphicon-ok form-control-feedback');
            }
        },
        'select': function () {
            var ele = $('#select-val');
            if (ele.val() > 4) {
                $('#val1').attr('disabled', true);
            } else {
                $('#val1').attr('disabled', false);
            }
        },
        'sendIt': function () {
            if (!jVal.errors) {
                $('#jform').submit();
            }
        }
    };
    $('#button').click(function () {
        var obj = $.browser.webkit ? $('body') : $('html');
        obj.animate({scrollTop: $('#jform').offset().top}, 750, function () {
            jVal.errors = false;
            jVal.val1();
            jVal.val2();
            jVal.sendIt();
        });

        return false;
    });
    $('#val1').change(jVal.val1);
    $('#val2').change(jVal.val2);
    $('#select-val').change(jVal.select);
});