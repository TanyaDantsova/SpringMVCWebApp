window.onload = function () {
    window.choose = [];
};

$('#add_item').click(function () {
    $('#order').before($('<p>', {
        name: 'list_order',
        form: 'order',
        text: document.getElementById("order").value
    }));

    window.choose.push(document.getElementById('order').value);  //запись в массив
    document.getElementById("input_order").value = window.choose;

    document.getElementById("makeYourOrder").innerHTML = "You have already chosen:";
});

// $('#submit').click(function () {  //печать в алерт массива
//     alert(window.choose)
// })