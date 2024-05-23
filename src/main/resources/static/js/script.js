function cancelar(){
	window.history.back();
}

function eliminarUsu(cod){
	if (confirm("¿ESTÁ SEGURO DE ELIMINAR ESTE EMPLEADO?")){
		document.location.href = "/usuario/eliminar/" + cod;
	}
}

function eliminarTar(cod){
	if (confirm("¿ESTÁ SEGURO DE ELIMINAR ESTA TARJETA?")){
		document.location.href = "/tarjeta/eliminar/" + cod;
	}
}

function eliminarAgeMovil(cod){
	if (confirm("¿ESTÁ SEGURO DE ELIMINAR ESTA AGENDA MOVIL?")){
		document.location.href = "/agendamovil/eliminar/" + cod;
	}
}

function descargar(){
	document.location.href = "/home/";
}

function busqueda(cod){
	if (confirm("¿ESTÁ SEGURO DE ELIMINAR ESTA AGENDA MOVIL?")){
		document.location.href = "/busquedacertificacion/" + cod;
	}
}

function eliminarMatePedi(cod){
	if (confirm("¿ESTÁ SEGURO DE ELIMINAR ESTE MATERIAL?")){
		document.location.href = "/materialferpedido/eliminar/" + cod;
	}
}

function eliminarMatePedi(cod){
			swal({
		  title: "Aviso",
		  text: "¿ESTA SEGURO DE ELIMINAR ESTA MATERIAL?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			 document.location.href = "/materialferpedido/eliminar/" + cod;
		  } else {
			  return;
		  }
	});
}

function eliminarMatePediser(cod){
			swal({
		  title: "Aviso",
		  text: "¿ESTA SEGURO DE ELIMINAR ESTA MATERIAL?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			 document.location.href = "/materialpedidoser/eliminar/" + cod;
		  } else {
			  return;
		  }
	});
}


function eliminarMatePediserclaro(cod){
			swal({
		  title: "Aviso",
		  text: "¿ESTA SEGURO DE ELIMINAR ESTA MATERIAL?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			 document.location.href = "/materialferclaropedido/eliminar/" + cod;
		  } else {
			  return;
		  }
	});
}

function eliminarMatewowPedi(cod){
	
		swal({
		  title: "Aviso",
		  text: "¿ESTA SEGURO DE ELIMINAR ESTA MATERIAL?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			 document.location.href = "/materialferwowpedido/eliminar/" + cod;
		  } else {
			  return;
		  }
	});
}


function eliminarPartCert(cod)
{
	swal({
		  title: "Aviso",
		  text: "¿ESTA SEGURO DE ELIMINAR ESTA PARTIDA?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location.href = "/partidacertificacion/eliminar/" + cod;
		  } else {
			  return;
		  }
	});
}

function eliminarPartEquipoCert(cod)
{
		swal({
		  title: "Aviso",
		  text: "¿ESTA SEGURO DE ELIMINAR ESTA PARTIDA?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location.href = "/partidaequipocertificacion/eliminar/" + cod;
		  } else {
			  return;
		  }
	});
}

function eliminarEquipo(cod){
	swal({
		  title: "Aviso",
		  text: "¿ESTA SEGURO DE ELIMINAR ESTE EQUIPO?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location.href = "/equipo/eliminar/" + cod;
		  } else {
			  return;
		  }
	});
}

function confirmarPedidoMaterial(cod){
		swal({
		  title: "Aviso",
		  text: "¿Desea confirmar el pedido?",
		  icon: "success",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			   window.location.href = "/kit/aprobarpedido/"+cod;
		  } else {
			  return;
		  }
	});
}

function eliminarTipBarem(cod){
	swal({
		  title: "Aviso",
		  text: "¿ESTA SEGURO DE ELIMINAR ESTE TIPO DE BAREMO?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location.href = "/tipobaremo/eliminar/" + cod;
		  } else {
			  return;
		  }
	});
}

function eliminarCatPar(cod){
	swal({
		  title: "Aviso",
		  text: "¿ESTA SEGURO DE ELIMINAR ESTA CATEGORIA DE PARTIDA?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location.href = "/partidacategoria/eliminar/" + cod;
		  } else {
			  return;
		  }
	});
}

function eliminarPedidoMaterial(cod){
	swal({
		  title: "Aviso",
		  text: "¿ESTA SEGURO DE ELIMINAR ESTE PEDIDO?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location.href = "/kit/eliminar/" + cod;
		  } else {
			  return;
		  }
	});
}


function BusquedaCertificacionAveria(cod){
	window.location.href = "/busquedacertificacion/" + cod;
}

function eliminarPar(cod){
	swal({
		  title: "Aviso",
		  text: "¿ESTA SEGURO DE ELIMINAR ESTA PARTIDA?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location.href = "/partida/eliminar/" + cod;
		  } else {
			  return;
		  }
	});
}

function eliminaAver(cod){
	swal({
		  title: "Aviso",
		  text: "¿ESTA SEGURO DE ELIMINAR ESTA AVERIA?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location.href = "/averias/eliminar/" + cod;
		  } else {
			  return;
		  }
	});
}
function eliminaFac(cod){
	swal({
		  title: "Aviso",
		  text: "¿ESTA SEGURO DE ELIMINAR ESTA FACTURACION?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location.href = "/facturacion/eliminar/" + cod;
		  } else {
			  return;
		  }
	});
}

function eliminarAgeFija(cod){
	if (confirm("¿ESTÁ SEGURO DE ELIMINAR ESTA AGENDA FIJA?")){
		document.location.href = "/agendafija/eliminar/" + cod;
	}
}

function accion(){
	swal("¡Gracias por usar esta aplicacion!");
}

function eliminarMaterialseriado(cod){
	swal({
		  title: "Aviso",
		  text: "¿ESTA SEGURO DE ELIMINAR ESTE MATERIAL SERIADO?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location.href = "/materialseriado/eliminar/" + cod;
		  } else {
			  return;
		  }
	});
}

function eliminarMaterial(cod){
	swal({
		  title: "Aviso",
		  text: "¿ESTA SEGURO DE ELIMINAR ESTE MATERIAL?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location.href = "/material/eliminar/" + cod;
		  } else {
			  return;
		  }
	});
}

function eliminarUsuarc(cod){
	swal({
		  title: "Aviso",
		  text: "¿ESTA SEGURO DE ELIMINAR ESTE USUARIO DE ESTA CUADRILLA?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location.href = "/usuariocuadrilla/eliminar/" + cod;
		  } else {
			  return;
		  }
	});
}

function eliminarProkit(cod){
	swal({
		  title: "Aviso",
		  text: "¿ESTA SEGURO DE ELIMINAR ESTE PRODUCTO?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location.href = "/productokit/eliminar/" + cod;
		  } else {
			  return;
		  }
	});
}

function eliminarKit(cod){
	swal({
		  title: "Aviso",
		  text: "¿ESTA SEGURO DE ELIMINAR ESTE KIT?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location.href = "/kit/eliminar/" + cod;
		  } else {
			  return;
		  }
	});
}

function eliminarTrab(cod){
	swal({
		  title: "Aviso",
		  text: "¿ESTA SEGURO DE ELIMINAR ESTE TRABAJO?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location.href = "/trabajo/eliminar/" + cod;
		  } else {
			  return;
		  }
	});
}

function eliminarSol(cod){
	swal({
		  title: "Aviso",
		  text: "¿ESTA SEGURO DE ELIMINAR ESTA SOLICITUD?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location.href = "/solicitud/eliminar/" + cod;
		  } else {
			  return;
		  }
	});
}

function eliminarCua(cod){
	swal({
		  title: "Aviso",
		  text: "¿ESTA SEGURO DE ELIMINAR ESTA CUADRILLA?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location.href = "/cuadrilla/eliminar/" + cod;
		  } else {
			  return;
		  }
	});
}

function eliminarCaj(cod){
	swal({
		  title: "Aviso",
		  text: "¿ESTA SEGURO DE ELIMINAR ESTA CAJA?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location.href = "/caja/eliminar/" + cod;
		  } else {
			  return;
		  }
	});
}

function eliminarEsp(cod){
	
	swal({
		  title: "Aviso",
		  text: "¿ESTA SEGURO DE ELIMINAR ESTE ESTADO DE PRODUCTO?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location.href = "/estadoproducto/eliminar/" + cod;
		  } else {
			  return;
		  }
	});

}

function eliminarTip(cod){
	
	swal({
		  title: "Aviso",
		  text: "¿ESTA SEGURO DE ELIMINAR ESTE TIPO DE PRODUCTO?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location.href = "/tipoproducto/eliminar/" + cod;
		  } else {
			  return;
		  }
	});

}

function eliminarPro(cod){
	
	swal({
		  title: "Aviso",
		  text: "¿ESTA SEGURO DE ELIMINAR ESTE PRODUCTO?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location.href = "/producto/eliminar/" + cod;
		  } else {
			  return;
		  }
	});

}

function eliminarObj(cod){
	
	swal({
		  title: "Aviso",
		  text: "¿Está Seguro de Eliminar este Objetivo?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location.href = "/objetivo/eliminar/" + cod;
		  } else {
			  return;
		  }
	});

}

function agenda(ven){
	var fecha = new Date(); //Fecha actual
				  var mes = fecha.getMonth()+1; //obteniendo mes
				  var dia = fecha.getDate(); //obteniendo dia
				  var ano = fecha.getFullYear(); //obteniendo año
				  if(dia<10)
			 	   dia='0'+dia; //agrega cero si el menor de 10
				  if(mes<10)
				    mes='0'+mes //agrega cero si el menor de 10
			  window.location.href = "/agenda/" + ven + "/" + ano+"-"+mes+"-"+dia;

}

function agendamovil(ven){
	var fecha = new Date(); //Fecha actual
				  var mes = fecha.getMonth()+1; //obteniendo mes
				  var dia = fecha.getDate(); //obteniendo dia
				  var ano = fecha.getFullYear(); //obteniendo año
				  if(dia<10)
			 	   dia='0'+dia; //agrega cero si el menor de 10
				  if(mes<10)
				    mes='0'+mes //agrega cero si el menor de 10
			  window.location.href = "/agendamovil/" + ven + "/" + ano+"-"+mes+"-"+dia;

}

function agendafija(ven){
	var fecha = new Date(); //Fecha actual
				  var mes = fecha.getMonth()+1; //obteniendo mes
				  var dia = fecha.getDate(); //obteniendo dia
				  var ano = fecha.getFullYear(); //obteniendo año
				  if(dia<10)
			 	   dia='0'+dia; //agrega cero si el menor de 10
				  if(mes<10)
				    mes='0'+mes //agrega cero si el menor de 10
			  window.location.href = "/agendafija/" + ven + "/" + ano+"-"+mes+"-"+dia;

}

function agendamovilsuper(ven){
	var fecha = new Date(); //Fecha actual
				  var mes = fecha.getMonth()+1; //obteniendo mes
				  var dia = fecha.getDate(); //obteniendo dia
				  var ano = fecha.getFullYear(); //obteniendo año
				  if(dia<10)
			 	   dia='0'+dia; //agrega cero si el menor de 10
				  if(mes<10)
				    mes='0'+mes //agrega cero si el menor de 10
			  window.location.href = "/agendamovilsuper/" + ven + "/" + ano+"-"+mes+"-"+(dia-2);

}

function agendafijasuper(ven){
	var fecha = new Date(); //Fecha actual
				  var mes = fecha.getMonth()+1; //obteniendo mes
				  var dia = fecha.getDate(); //obteniendo dia
				  var ano = fecha.getFullYear(); //obteniendo año
				  if(dia<10)
			 	   dia='0'+dia; //agrega cero si el menor de 10
				  if(mes<10)
				    mes='0'+mes //agrega cero si el menor de 10
			  window.location.href = "/agendafijasuper/" + ven + "/" + ano+"-"+mes+"-"+(dia-2);

}

function eliminarVenMov(cod){
	
	swal({
		  title: "Aviso",
		  text: "¿Está Seguro de Eliminar esta Venta Movil?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location.href = "/ventamovil/eliminar/" + cod;
		  } else {
			  return;
		  }
	});

}

function eliminarFun(cod){
	
	swal({
		  title: "Aviso",
		  text: "¿Está Seguro de Eliminar este Funnel?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location.href = "/funnel/eliminar/" + cod;
		  } else {
			  return;
		  }
	});

}

function eliminarOrd(cod){
	if (confirm("¿ESTÁ SEGURO DE ELIMINAR ESTA ORDEN?")){
		document.location.href = "/ordencompra/eliminar/" + cod;
	}
}

function eliminarProOrd(cod){
	if (confirm("¿ESTÁ SEGURO DE ELIMINAR ESTE PRODUCTO DE LA ORDEN?")){
		document.location.href = "/productoorden/eliminar/" + cod;
	}
}

function eliminarCar(cod){
	if (confirm("¿ESTÁ SEGURO DE ELIMINAR ESTE CARRITO?")){
		document.location.href = "/productoorden/eliminar/" + cod;
	}
}

function eliminarCarPro(cod){
	if (confirm("¿ESTÁ SEGURO DE ELIMINAR ESTE PRODUCTO DE CARRITO?")){
		document.location.href = "/carritoproducto/eliminar/" + cod;
	}
}

function eliminarTablet(cod){
	if (confirm("¿ESTÁ SEGURO DE ELIMINAR ESTE EJECUTIVO DE TABLET?")){
		document.location.href = "/tablet/eliminar/" + cod;
	}
}



function eliminarSub(cod){
	
	swal({
		  title: "Aviso",
		  text: "¿ESTA SEGURO DE ELIMINAR ESTA CATEGORIA?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location.href = "/subcategoria/eliminar/" + cod;
		  } else {
			  return;
		  }
	});

}

function guardarCategoriaPri(){
	
	swal({
		  title: "Aviso",
		  text: "¿Está Seguro?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location.href = "/categoriapri/grabar";
		  } else {
			  return;
		  }
	});;
}

function eliminarCat(cod){
	
	swal({
		  title: "Aviso",
		  text: "¿ESTA SEGURO DE ELIMINAR ESTE CENTRO DE COSTO?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location.href = "/categoria/eliminar/" + cod;
		  } else {
			  return;
		  }
	});
	
}

function eliminarVisita(cod){
	
	swal({
		  title: "Aviso",
		  text: "¿ESTA SEGURO DE ELIMINAR VISITA?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location.href = "/certificacion/visita/eliminar/" + cod;
		  } else {
			  return;
		  }
	});

}
	
function eliminarVisitaEquipo(cod){
	
	swal({
		  title: "Aviso",
		  text: "¿ESTA SEGURO DE ELIMINAR VISITA?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  if (willDelete) {
			  window.location.href = "/certificacionequipo/visita/eliminar/" + cod;
		  } else {
			  return;
		  }
	});	
	
}


document.addEventListener('DOMContentLoaded', function() {
    const chatBox = document.getElementById('chat-box');
    const userInput = document.getElementById('user-input');
    const sendButton = document.getElementById('send-button');

    // Función para agregar un mensaje al chat box
    function addMessage(role, content) {
        const messageElement = document.createElement('div');
        messageElement.classList.add('message');
        messageElement.classList.add(role);
        messageElement.textContent = content;
        chatBox.appendChild(messageElement);
        // Desplazar el chat box hacia abajo para mostrar el último mensaje
        chatBox.scrollTop = chatBox.scrollHeight;
    }

    // Función para enviar el mensaje del usuario
    function sendMessage() {
        const userMessage = userInput.value.trim();
        if (userMessage !== '') {
            addMessage('user', userMessage);
            // Aquí puedes enviar el mensaje del usuario al servidor
            fetch('/chat/complete', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: new URLSearchParams({
                    'userMessage': userMessage
                })
            })
            .then(response => response.json())
            .then(data => {
                const assistantMessage = data.choices[0].message.content;
                addMessage('assistant', assistantMessage);
            })
            .catch(error => {
                console.error('Error:', error);
                addMessage('assistant', 'Lo siento, hubo un error al procesar tu solicitud.');
            });

            // Limpiar el campo de entrada
            userInput.value = '';
        }
    }

    // Manejar el clic en el botón de enviar
    sendButton.addEventListener('click', sendMessage);

    // Manejar la pulsación de Enter en el campo de entrada
    userInput.addEventListener('keypress', function(event) {
        if (event.key === 'Enter') {
            sendMessage();
        }
    });
});
