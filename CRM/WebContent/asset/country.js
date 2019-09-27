

$('document').ready(function(){
$.getJSON('FetchCountryJSON',{ajax:true},function(data){
//alert(data);
		  
	$('#ecountry').append($('<option>').val('Country').text('Country'));	  
  $.each(data,function(i,item){
  $('#ecountry').append($('<option>').val(item.COUNTRYID).text(item.COUNTRYNAME));	  
  });	
});	


$('#ecountry').change(function(){
	
$.getJSON("FetchStateByCountryIdJSON",{ajax:true,countryid:$('#ecountry').val()},function(data){
	 $('#estate').empty();
	 $('#estate').append($('<option>').val('State').text('State'));	  
	$.each(data,function(i,item){
		  $('#estate').append($('<option>').val(item.STATEID).text(item.STATENAME));	  
		  });
	
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
