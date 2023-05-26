<%@ include file="head.jsp" %>
<%@ include file="menu.jsp" %>

<div class="col-10" style="">

<div class="mt-5 row">

<div class="col">
    <div class="card p-0">
     <div class="card-body" style="border-bottom: 3px solid red">
        <h3 class="card-title text-center">${instituicoesQtd}</h3>
        <h3 class="card-title text-center">Universidades</h3>
    </div>
    </div>
</div>

<div class="col">
    <div class="card p-0">
     <div class="card-body" style="border-bottom: 3px solid red">
        <h3 class="card-title text-center">${cursoQtd}</h3>
        <h3 class="card-title text-center">Cursos</h3>
    </div>
    </div>
</div>

<div class="col">
    <div class="card p-0">
     <div class="card-body" style="border-bottom: 3px solid red">
        <h3 class="card-title text-center">${turmaQtd}</h3>
        <h3 class="card-title text-center">Turmas</h3>
    </div>
    </div>
</div>

<div class="col">
    <div class="card p-0">
     <div class="card-body" style="border-bottom: 3px solid red">
        <h3 class="card-title text-center">${contaQtd}</h3>
        <h3 class="card-title text-center">Contas</h3>
    </div>
    </div>
</div>

<div class="col">
    <div class="card p-0">
     <div class="card-body" style="border-bottom: 3px solid red">
        <h3 class="card-title text-center">${postagemQtd}</h3>
        <h3 class="card-title text-center">Postagens</h3>
    </div>
    </div>
</div>

</div>

<div class="container-fluid mt-5">
    <div class="row h-100" style="max-height: 200px">
      <div class="col-8 bg-light opacity-75 shadow">
        <div class="chart-container">
          <canvas id="myChart" class="w-100 h-100"></canvas>
        </div>
      </div>
      <div class="col-4 bg-light opacity-75 shadow">
        <div class="chart-container d-flex justify-content-center" style="max-height: 350px">
          <canvas id="grafico2"></canvas>
        </div>
      </div>
    </div>
  </div>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script>

  const ctx2 = document.getElementById('grafico2');
  const ctx = document.getElementById('myChart');

  let area = []
  let qtd = []

  fetch('http://localhost:8080/api_chart_area_curso')
  .then(response => response.json())
  .then(data => {
      data.forEach(element => {
        area.push(element.area)
        qtd.push(element.qtd)
      });
  })
  .catch(error => {
    // Tratar erros
    console.error('Ocorreu um erro:', error);
  });

  console.log(area);
  console.log(qtd);

  new Chart(ctx, {
    type: 'bar',
    data: {
      labels: area,
      datasets: [{
        label: '# of Votes',
        data: qtd,
        backgroundColor: [
          'rgb(200, 0, 0)'
        ],
        borderWidth: 1
      }]
    },
    options: {
      scales: {
        y: {
          beginAtZero: true
        }
      }
    }
  });

new Chart(ctx2, {
    type: 'pie',
    data : {
      labels: [
        'Red',
        'Blue',
        'Yellow'
      ],
      datasets: [{
        label: 'My First Dataset',
        data: [300, 50, 100],
        backgroundColor: [
          'rgb(255, 23, 0)',
          'rgb(255, 21, 43)',
          'rgb(255, 1, 81)'
        ],
        hoverOffset: 4
      }]
    }
  });

</script>

</div>
</div>
<%@ include file="footer.jsp" %>