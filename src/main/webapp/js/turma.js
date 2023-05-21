function getCursos(id){
    return fetch("http://localhost:8080/api_cursos?instituicao_id="+id)
        .then(response => response.json())
        .then(data => {
            return data
        })
}

