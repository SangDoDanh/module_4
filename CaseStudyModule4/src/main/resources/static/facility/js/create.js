let selectFacilityType = document.getElementById("facility-facilityType");

selectFacilityType.addEventListener('change', (e) => {
    autoSelectFacilityType(e.target.value);
})

function autoSelectFacilityType(facilityTypeId) {
    switch (facilityTypeId){
        //Villa
        case '1':
            document.getElementById('facility-villa').hidden = false;
            document.getElementById('facility-house').hidden = false;
            document.getElementById('facility-room').hidden = true;
            break;
        //Home
        case '2':
            document.getElementById('facility-villa').hidden = true;
            document.getElementById('facility-house').hidden = false;
            document.getElementById('facility-room').hidden = true;
            break;

            // Room
        default:
            document.getElementById('facility-villa').hidden = true;
            document.getElementById('facility-house').hidden = true;
            document.getElementById('facility-room').hidden = false;
    }
}
autoSelectFacilityType(selectFacilityType.value);