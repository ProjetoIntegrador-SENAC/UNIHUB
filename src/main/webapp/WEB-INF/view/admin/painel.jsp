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

  new Chart(ctx, {
    type: 'bar',
    data: {
      labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
      datasets: [{
        label: '# of Votes',
        data: [12, 19, 3, 5, 2, 3],
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
          'rgb(255, 99, 132)',
          'rgb(54, 162, 235)',
          'rgb(255, 205, 86)'
        ],
        hoverOffset: 4
      }]
    }
  });



</script>

</div>
</div>
<%@ include file="footer.jsp" %>