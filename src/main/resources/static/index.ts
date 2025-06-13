document.addEventListener("DOMContentLoaded", () => {
    fetch('/index')
        .then(response => response.json())
        .then(data => {
            const tbody = document.getElementById('commessaTable')!.querySelector('tbody')!;
            data.forEach((commessa: any) => {
                const row = document.createElement('tr');
                row.innerHTML = `<td>${commessa.c_AZN}</td><td>${commessa.c_COM}</td><td>${commessa.t_COM}</td>`;
                tbody.appendChild(row);
            });
        });
});