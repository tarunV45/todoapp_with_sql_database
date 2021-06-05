function addItem() {
    let item = document.getElementById("newItem").value;

    if (item == "") {
        return;
    }

    let newItem = `<tr id=${item}tr>
        <td colspan="3">${item}</td>
        <td class="buttonStyle">
            <button class="delItem" id=${item} onclick="deleteItem(this.id)">Delete</button>
        </td>
        </tr>`;
        
    document.getElementById("todoList").innerHTML += newItem;

    document.getElementById("newItem").value = "";

    window.open(`http://localhost:8080/todoapp/adddata?newItem=${item}`);
}

function deleteItem(id) {
    rowID = id+"tr";
    document.getElementById(rowID).style.display="none";
    window.open(`http://localhost:8080/todoapp/deldata?newItem=${id}`);
}

function clearAll() {
    document.getElementById("todoList").innerHTML = "";
    window.open(`http://localhost:8080/todoapp/deleteall`);
}