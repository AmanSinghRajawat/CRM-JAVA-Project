

$('document').ready(function(){
$.getJSON('FetchStatesJSON',{ajax:true},function(data){
  	  
	$('#estate').append($('<option>').val('State').text('State'));	  
  $.each(data,function(i,item){
  $('#estate').append($('<option>').val(item.STATEID).text(item.STATENAME));	  
  });	
});	


$('#estate').change(function(){
	
$.getJSON("FetchCityByStateIdJSON",{ajax:true,stateid:$('#estate').val()},function(data){
	 $('#ecity').empty();
	 $('#ecity').append($('<option>').val('City').text('City'));
	$.each(data,function(i,item){
		  $('#ecity').append($('<option>').val(item.CITYID).text(item.CITYNAME));	  
		  });
	
});	
	
});


	
});


//This State Methode for Company 

$('documenet').ready(function(){
$.getJSON('FetchStatesJSON',{ajax:true},function(data){
  
	$('#comcity').append($('<option>').val('-Select-').text('-Select-'));	  
	$('#comstate').append($('<option>').val('-Select-').text('-Select-'));	  
  $.each(data,function(i,item){
  $('#comstate').append($('<option>').val(item.STATEID).text(item.STATENAME));	  
  });	
});	


$('#comstate').change(function(){
	
$.getJSON("FetchCityByStateIdJSON",{ajax:true,stateid:$('#comstate').val()},function(data){
	 $('#comcity').empty();
	$.each(data,function(i,item){
		$('#comcity').append($('<option>').val('-Select-').text('-Select-'));
		  $('#comcity').append($('<option>').val(item.CITYID).text(item.CITYNAME));	  
		  });
	
});	
	
});


	
});




