$(document).ready(function (){
    $('#add_product').click(function (){
        $('#loadingmessage').show();
        $.ajax({
            'url': '/add_products',
            'type': 'GET',
            success: function (data)
            {
                if (data.error) {
                    alert(data.message);
                }
                $('#loadingmessage').hide();
                addModal(data, saveProduct);
            },
            error : function (data)
            {
                $('#loadingmessage').hide();
                alert(data.message);
            }
        });
    });

    $('#add_category').click(function (){
        $.ajax({
            'url': '/add_category',
            'type': 'GET',
            success: function (data)
            {
                if (data.error) {
                    alert(data.message);
                }
                $('#loadingmessage').hide();
                addModal(data, saveCategory);
            },
            error : function (data)
            {
                $('#loadingmessage').hide();
                alert(data.message);
            }
        });
    });

    $('#notify_users').click(function (){
            $('#loadingmessage').show();
            $.ajax({
                'url': '/api/notify_users',
                'type': 'GET',
                success: function (data)
                {
                    if (data.error) {
                        alert(data.message);
                    }

                    $('#loadingmessage').hide();
                },
                error : function (data)
                {
                    $('#loadingmessage').hide();
                    alert(data.message);
                }
            });
        });

    function addModal(data, callback) {
        var modal = $('<div style="display: none; height:570px; width: 600px !important"></div>');
        modal.html(data).dialog({
            title: '',
            modal: true,
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

    function saveCategory(){
        var data = $("form").serializeJSON();
        $.ajax({
            'url': '/add_category',
            'type': 'POST',
            data: JSON.stringify({data}),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data)
            {
                if (data.error) {
                    alert(data.message);
                }
                alert("Categoria a fost adaugata cu succes!");
            },
            error : function (data)
            {
                alert(data.message);
            }
        });
    }
});