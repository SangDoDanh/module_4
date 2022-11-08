let searchFacilityType = document.getElementById("search-facility-type");
let btnEdit = document.querySelectorAll(".btn-edit");


// gán lại giá trị facility type vừa mới tìm kiếm
document.getElementById("auto-select-facility").click();
function autoSelectFacilityType(facilityType) {
    searchFacilityType.value = facilityType;
}

/**
 * Gán giá trị id và name của facility muốn xóa lên modal delete
 *
 * @param idDelete
 * @param nameDelete
 */
function deleteFacility(idDelete, nameDelete) {
    document.getElementById('id-delete').value = idDelete;
    document.getElementById('name-delete').innerText = nameDelete;
}

btnEdit.forEach((e) => {
    e.addEventListener('click', function () {
        let selectFacilityTypeEdit = document.getElementById("facility-facilityTypeEdit");
        autoSelectFacilityTypeEdit(selectFacilityTypeEdit.value);
        selectFacilityTypeEdit.addEventListener('change', (e) => {
            autoSelectFacilityTypeEdit(e.target.value);
        });
    })
});

/**
 * Hiển thị theo facility type
 *  + ẩn đi các trường dư thừa
 * @param facilityTypeId
 */

function autoSelectFacilityTypeEdit(facilityTypeId) {
    switch (facilityTypeId){
        case '1':
            document.getElementById('facility-villa').hidden = false;
            document.getElementById('facility-house').hidden = false;
            document.getElementById('facility-room').hidden = true;
            break;
        case '2':
            document.getElementById('facility-villa').hidden = true;
            document.getElementById('facility-house').hidden = false;
            document.getElementById('facility-room').hidden = true;
            break;
        default:
            document.getElementById('facility-villa').hidden = true;
            document.getElementById('facility-house').hidden = true;
            document.getElementById('facility-room').hidden = false;
    }
}


/**
 * Gán ngược giá trị các thuộc tính của đối tượng facility edit, lên "Edit Modal"
 *
 * Tất cả @param là thuộc tính của đối tượng facility cần edit
 */
function editFacility(id, name,area, maxPeople,facilityTypeId,rentTypeId,
                      facilityFree, numberOfFloors,poolArea, description,
                      standardRoom, cost) {
    document.getElementById("facility-id").value = id;
    document.getElementById("facility-name").value = name;
    document.getElementById("facility-area").value = area;
    document.getElementById("facility-maxPeople").value = maxPeople;
    document.getElementById("facility-facilityTypeEdit").value = facilityTypeId;
    document.getElementById("facility-rentType").value = rentTypeId;
    document.getElementById("facility-facilityFree").value = facilityFree;
    document.getElementById("facility-numberOfFloors").value = numberOfFloors != 'null' ? numberOfFloors : 0;
    document.getElementById("facility-poolArea").value = poolArea != 'null' ? poolArea : 0;
    document.getElementById("facility-description").value = description;
    document.getElementById("facility-standardRoom").value = standardRoom;
    document.getElementById("facility-cost").value = cost;
}