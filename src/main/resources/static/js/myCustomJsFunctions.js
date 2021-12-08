
var appraisalMarksJsonCommon = [];
var employeeJsonCommon = [];
var departmentsJsonCommon = [];
var appraisalHeadsJsonCommon = [];

function funGetTableFromJsonData(jsonData,tableName){
	
	var keys = $.map( jsonData[0], function( value, key ) {
		  return key;
		});
		
		//$('#DynTbl').append('<table id="dytable" border=1><tr id="dth"></tr></table>');

		/* $.each(keys, function(key,value) {
		    $('#dth').append('<th>'+value+'</th>');
		}); */

		//$('#' + tableName).append("<tbody>");
		$.each(jsonData, function(index,data) {

			$('#' + tableName).append('<tr id="t'+index+'"></tr>');

				var values = $.map( data, function( value, key ) {
			  	return value;
			});

			$.each(values, function(key,value) {
			    $('#t'+index).append('<td>'+value+'</td>');
			});
		});
		//$('#' + tableName).append("</tbody>");
		//alert($('#' + tableName).html())
}


//Getting All User List
/*$.post("/diusoftware/showAllUsers",function(data){		
	for ( var key in data) { 
		
		var element = {empCode:[],empName:[],empDesig:[],empDept:[]};	
		element["empCode"]  = data[key].userCode;
		element["empName"]  = data[key].name;
		element["empDesig"] = data[key].designation;
		element["empDept"]  = data[key].department;
		element["joinDate"]  = data[key].joinDate;
		employeeJsonCommon.push(element);
	}	
	
	// Preparing department JSON list
	var departmentNames = $.unique(employeeJsonCommon.map(function (d) {return d.empDept;}));

	for(var i = 0; i < departmentNames.length; i++){
		departmentsJsonCommon.push(departmentNames[i]);	
	} // End
	
});	 // End Post method user list	*/


//Function for getting employee list
function funGetAppEmployeeListCommon(){
	
	//var employeeJson = [];	
	return employeeJsonCommon;
	
} //End funGetAppEmployeeListCommon() 



//Function for generating year dropdown
function funGetYearDropDown(comboId, yearRange){
	var date = new Date();
	var curYear = date.getFullYear();
	var htmlCode = '<select class="form-control" id="' + comboId + '" name="' + comboId + '">';
	var optionBellow = '';
	var optionUp = '';
	
	for(var i = 1; i <= yearRange; i++){
		optionUp += '<option value="' + (curYear + i) + '">' + (curYear + i) + '</option>';
	}
	
	for(var i = yearRange; i >= 1; i--){
		
		optionBellow += '<option value="' + (curYear - i) + '">' + (curYear - i) +  '</option>';
	}
	
	htmlCode += optionBellow + '<option value="' + curYear + '" selected>' + curYear + '</option>' + optionUp + '</select>'; 
	
	return htmlCode;
	
} // End funGetYearDropDown()


//Function for getting employee name from json array
function funGetEmployeeNameFromJson(vEmoCode){
	
	var empName = '';
	
	$.each(employeeJsonCommon, function(i, v) {
	    if (v.empCode == vEmoCode) {
	  
	    	empName = v.empName;
	        
	    	return;
	    } 
	});
	
	//alert(empName);
	
	return empName;
} // End funGetEmployeeNameFromJson()



//Function for getting employee name,designation,department from json array
function funGetEmpNameDesigDept(vEmoCode){
	
	var empName = '';
	
	$.each(employeeJsonCommon, function(i, v) {
	    if (v.empCode == vEmoCode) {
	  
	    	empName = v.empName + ', ' + v.empDesig + ', ' +  v.empDept;
	        
	    	return;
	    } 
	});
	
	//alert(empName);
	
	return empName;
} // End funGetEmployeeNameFromJson()


//Getting appraisal marks list with details

/*$.post("/diusoftware/getAppraisalMarskList",function(data){
					
	for ( var key in data) { 
		var element = {id:[],marks:[],marksDesc:[],versionNo:[]};	
		element["id"]  = data[key].id;
		element["marks"]  = data[key].marks;
		element["marksDesc"] = data[key].marksDesc;
		element["versionNo"] = data[key].versionNo;
		appraisalMarksJsonCommon.push(element);
		
	} //End for key in data
	
}); // End of appraisal marks list*/



//Function for returning appraisal marks list with details
function funGetAppraisalMarksList(){
	return appraisalMarksJsonCommon;
}



/* Function returns marks head name from appraisalMarksJsonCommon */ 
function funGetMarksHeadNameFromJson(vMarks,vVersion){
	
	var marksTitle = '';
	
	$.each(appraisalMarksJsonCommon, function(i, v) {
	    if (v.marks == vMarks && v.versionNo == vVersion) {
	    	marksTitle = v.marksDesc;
	        return;
	    } 
	});		
	
	return marksTitle;
	
	
} // End funGetAppraisalHeadName()



//Function for returning appraisal marks list with details
function funGetDepartmentListCommon(){
	
	return departmentsJsonCommon;
}



//Getting appraisal head lists
/*$.post("/diusoftware/appraisalheads",function(data){
			
	for ( var key in data) { 
		var element = {id:[],headName:[],headType:[],headDesc:[],headParent:[]};	
		element["id"]  = data[key].id;
		element["headName"]  = data[key].headName;
		element["headType"] = data[key].headType;
		element["headDesc"] = data[key].headDesc;
		element["headParent"] = data[key].fk_Appraisalheads;
		
		appraisalHeadsJsonCommon.push(element);
		
	} //End for key in data
	
}); // End of appraisal head list*/




// Function for getting appraisal head list
function funGetAppraisalHeadsCommon(){
	
	return appraisalHeadsJsonCommon;
} // End of funGetAppraisalHeadsCommon



// Function for returning appraisal head name
function funGetAppraisalHeadName(vHeadId){
	
	var headName = '';
	
	$.each(appraisalHeadsJsonCommon, function(i, v) {
	    if (v.id == vHeadId) {
	  
	    	headName = v.headName;
	        
	    	return;
	    } 
	});
		
	return headName;
} // End funGetAppraisalHeadName()



//Function for returning appraisal head group name
function funGetAppraisalHeadGroupName(vHeadId){
	
	var headParent = '';
	
	$.each(appraisalHeadsJsonCommon, function(i, v) {
	    if (v.id == vHeadId) {
	  
	    	headParent = v.headParent;
	        
	    	return;
	    } 
	});
	
	if(headParent != ''){
		return funGetAppraisalHeadName(headParent);
	} else {
		return null;
	}
	
} // End funGetAppraisalHeadName()



////////////////////////////////////////////////////////////
function funCurDate(){
	var m_names = new Array("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
	var month= new Array("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");
	var d = new Date();
	var curr_date = d.getDate();
	//alert(("0" + curr_date).slice(-2));
	var curr_month = d.getMonth();
	var curr_year = d.getFullYear();
	var date = curr_year + "-" + month[curr_month] + "-" + ("0" + curr_date).slice(-2);
	return date;
	//alert(curr_date + "-" + curr_month + "-" + curr_year);
}

////////////////////////////////////////////////////////////