function eliminar(id) {
	swal({
		title: "Estas seguro de Dar de Baja al Usuario?",
		text: " ",
		icon: "warning",
		buttons: true,
		dangerMode: true,
	})
		.then((OK) => {
			if (OK) {
				$.ajax({
					url:"/eliminar"+id,
					success : function(res){
						console.log(res);
					}
				});
				swal("Se dio de baja al Usuario!", {
					icon: "success",
				}).then((ok)=>{
					if(ok){
						location.href="/listar";
					}
				});
			} else {
				swal("Nadie fue dado de baja!");
			}
		});
}