<form id="add_categories_form" method="POST" >
  <div class="form-group">
        <label for="categoryName">Nume categorie</label>
        <input type="text" class="form-control" id="categoryName" name="name">
  </div>
  <div class="form-group">
        <label for="parentId">Categorie parinte</label>
        <select class="form-control" id="parentId" name="parentId">
            <#list categories as category>
                <option value="${category.id}">${category.name}</option>
            </#list>
        </select>
  </div>
  <div class="checkbox">
        <label for="status">Status</label>
        <select class="form-control" id="status" name="status">
            <option value=1>Activ</option>
            <option value=0>Inactiv</option>
        </select>
  </div>
</form>