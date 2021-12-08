function timeFormat12to24(time){
	//var time = $("#inputId").val();
	var hours = Number(time.match(/^(\d+)/)[1]);
	var minutes = Number(time.match(/:(\d+)/)[1]);
	var AMPM = time.match(/\s(.*)$/)[1];
	if (AMPM == "PM" && hours < 12) hours = hours + 12;
	if (AMPM == "AM" && hours == 12) hours = hours - 12;
	var sHours = hours.toString();
	var sMinutes = minutes.toString();
	//var sSecond = 00;
	if (hours < 10) sHours = "0" + sHours;
	if (minutes < 10) sMinutes = "0" + sMinutes;
	var finalFormat = sHours + ":" + sMinutes + ":00" ;
	return finalFormat;
}

function timeFormat24to12(time) {
    //var time = $("#starttime").val();
    var hours = Number(time.match(/^(\d+)/)[1]);
    var minutes = Number(time.match(/:(\d+)/)[1]);  
    var ampm = hours < 12 ? "AM" : "PM";
    if (hours > 12){hours = hours - 12;}
    if (hours == 0){hours = hours + 12;}
    var sHours = hours.toString();
    var sMinutes = minutes.toString();
    if (hours < 10) sHours = "0" + sHours;
    if (minutes < 10) sMinutes = "0" + sMinutes;
    return (sHours + ":" + sMinutes + " " + ampm);
}

/*$("#btnConvert").on("click", function () {
    ConvertTimeformat("24", $("#txttime").val());
});*/