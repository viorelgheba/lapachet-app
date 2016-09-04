<form id="add_products_form" method="POST" >
  <div class="form-group">
        <label for="productName">Nume produs</label>
        <input type="text" class="form-control" id="productName" name="name">
  </div>
  <div class="form-group">
        <label for="productName">Categorie</label>
        <select class="form-control" id="category" name="categoryId">
            <#list categories as category>
                <option value="${category.id}">${category.name}</option>
            </#list>
        </select>
    </div>
  <div class="form-group">
        <label for="productDescription">Descriere produs</label>
        <textarea class="form-control" rows="3" id="productDescription"  name="description"></textarea>
  </div>
  <div class="input-group">
        <div class="input-group-addon">RON</div>
        <input type="text" class="form-control" id="basePrice" placeholder="Pret de baza" name="basePrice">
        <div class="input-group-addon">.00</div>
  </div>
  <div class="form-group">
          <label for="grammage">Gramaj</label>
          <input type="text" class="form-control" id="grammage" name="grammage">
    </div>
    <div class="form-group">
            <label for="unit">UM</label>
            <input type="text" class="form-control" id="unit" name="unit">
      </div>

</form>