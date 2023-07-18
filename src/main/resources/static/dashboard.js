(function () {
  'use strict';

  feather.replace({ 'aria-hidden': 'true' });

  // Obtener los datos de la tabla
  var tabla = document.querySelector('.table.table-striped.table-sm');
  var filas = tabla.querySelectorAll('tbody tr');

  // Crear arreglos para almacenar las fechas y los datos de facturas por día
  var fechas = [];
  var facturasPorDia = [];

  // Obtener las fechas y los datos de facturas por día de la tabla
  for (var i = 0; i < filas.length; i++) {
    var fechaCell = filas[i].querySelector('.fecha');
    var facturaCell = filas[i].querySelector('td:nth-child(3)');

    var fecha = fechaCell.innerText;
    var factura = parseInt(facturaCell.innerText);

    fechas.push(fecha);
    facturasPorDia.push(factura);
  }

  // Crear la gráfica con los datos obtenidos de la tabla
  var ctx = document.getElementById('myChart');
  var myChart = new Chart(ctx, {
    type: 'line',
    data: {
      labels: fechas,
      datasets: [{
        data: facturasPorDia,
        lineTension: 0,
        backgroundColor: 'transparent',
        borderColor: '#007bff',
        borderWidth: 4,
        pointBackgroundColor: '#007bff'
      }]
    },
    options: {
      scales: {
        yAxes: [{
          ticks: {
            beginAtZero: false
          }
        }]
      },
      legend: {
        display: false
      }
    }
  });
})();
