$(document).ready(function (){
    $('#add_product').click(function (){
        $.ajax({
            'url': '/add_products',
            'type': 'GET',
            success: function (data)
            {
                if (data.error) {
                    alert(data.message);
                }
                addModal(data, saveProduct);
            },
            error : function (data)
            {
                alert(data.message);
            }
        });
    });

    $('#add_category').click(function (){
        alert("here");
    });

    function addModal(data, callback) {
        var modalClass = 'modal-dlg';
        var modal = $('<div class="' + modalClass + '" style="display: none;"></div>');
        modal.html(data).dialog({
            title: '',
            modal: true,
            height: '400px',
            width: '600px',
            minHeight: '400px',
            minWidth: '600px',
            buttons:
            { "Save": function () {
                if (typeof callback === 'function') {
                    callback();
                    $(this).dialog('close');
                }
            }}
        });
    }

    function saveProduct(){
        var data = $("form").serializeJSON();
        $.ajax({
            'url': '/add_products',
            'type': 'POST',
            data: JSON.stringify({data}),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data)
            {
                if (data.error) {
                    alert(data.message);
                }
                alert("Produsul a fost adaugat cu succes!");
            },
            error : function (data)
            {
                alert(data.message);
            }
        });
    }
});