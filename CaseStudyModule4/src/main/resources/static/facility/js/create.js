let selectFacilityType = document.getElementById("facility-facilityType");

selectFacilityType.addEventListener('change', (e) => {
    autoSelectFacilityType(e.target.value);
})

function autoSelectFacilityType(facilityTypeId) {
    switch (facilityTypeId){
        //Villa
        case '1':
            document.getElementById('facility-villa').style.display = "block";
            document.getElementById('facility-house').style.display = "block";
            document.getElementById('facility-room').style.display = "none";
            break;
        //Home
        case '2':
            document.getElementById('facility-villa').style.display = "none";
            document.getElementById('facility-house').style.display = "block";
            document.getElementById('facility-room').style.display = "none";
            break;

            // Room
        default:
            document.getElementById('facility-villa').style.display = "none";
            document.getElementById('facility-house').style.display = "none";
            document.getElementById('facility-room').style.display = "block";

    }
}
autoSelectFacilityType(selectFacilityType.value);

// xu loai bo loi mac dinh khi convert string sang number
let errorStringToNumber = document.querySelectorAll(".error");
errorStringToNumber.forEach(e => {
    let message = e.innerText;
    if(message.length > 33) {
        console.log('o con mo no ke di!')
        message = message.slice(-23)
    }
    console.log(message)
    e.innerText = message;
    e.style.color = 'red';
})