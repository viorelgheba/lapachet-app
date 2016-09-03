<form id="add_products_form>
  <div class="form-group">
        <label for="productName">Nume produs</label>
        <input type="text" class="form-control" id="productName">
  </div>
  <div class="form-group">
        <label for="productName">Categorie</label>
        <select class="form-control">
            <#list categories as category>
                <option value="${category.id}">${category.name}</option>
            </#list>
        </select>
    </div>
  <div class="form-group">
        <label for="productDescription">Descriere produs</label>
        <textarea class="form-control" rows="3" id="productDescription"></textarea>
  </div>
  <div class="input-group">
        <div class="input-group-addon">RON</div>
        <input type="text" class="form-control" id="basePrice" placeholder="Pret de baza">
        <div class="input-group-addon">.00</div>
  </div>
</form>