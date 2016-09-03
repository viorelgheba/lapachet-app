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
                addModal(data);
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
            height: 400,
            width: 350,
            buttons:
            { "Save": function () {
                if (typeof callback === 'function') {
                    callback();
                }
                $(this).dialog("close");
            }}
        });
    }

    function saveProduct(){
        alert("saveProduct");
    }
});