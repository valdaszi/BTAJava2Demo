
$('h1').html('Labasrytas ');

// $('#app-container').html('<button id="button-ok">OK</button>');
//
// $('#button-ok').click(function(ev) {
//     $('#app-container').html('YES');
// });

employees(0, 10);

function employees(pageNo, pageSize) {
    //window.history.pushState("Display Employee page " + pageNo, "Employee", "?pageNo=" + pageNo + "&pageSize=" + pageSize);
    var skip = pageNo * pageSize;
    $.get('../api/employee/list', {skip: skip, size: pageSize})
        .done(function(data) {
            drawTable(data, pageNo, pageSize);
        });
}

function drawTable(data, pageNo, pageSize) {
    var html = '';

    if (pageNo > 0) {
        html += '<button id="bt-back">Back</button>';
    }
    html += '<button id="bt-next">Next</button>';

    html +=
        '<table>' +
            '<tr>' +
                '<th>#</th>' +
                '<th>First name</th>' +
                '<th>Last name</th>' +
                '<th>Birth date</th>' +
                '<th>Gender</th>' +
                '<th>Hired date</th>' +
            '</tr>';

    data.forEach(function(emp) {
        html +=
            '<tr>' +
            '<td><a href="#" onclick="employee(' + emp.empNo + ');return false;">' + emp.empNo + '</a></td>' +
            '<td>' + emp.firstName + '</td>' +
            '<td>' + emp.lastName + '</td>' +
            '<td>' + emp.birthDate + '</td>' +
            '<td>' + emp.gender + '</td>' +
            '<td>' + emp.hireDate + '</td>' +
            '</tr>';
    });

    html += '</table>';

    $('#app-container').html(html);

    $('#bt-next').click(function() {
        employees(pageNo + 1, pageSize);
    });
    $('#bt-back').click(function() {
        employees(pageNo > 0 ? pageNo - 1 : 0, pageSize);
    });
}

function employee(no) {
    //alert("Employee - clicked: " + no);
    $.get('../api/salary/' + no).done(function(data) {
        //alert("Employee - salary: " + data.length);

        var html =
            '<table>' +
            '<tr>' +
            '<th>From</th>' +
            '<th>To</th>' +
            '<th>Salary</th>' +
            '</tr>';

        data.forEach(function(sal) {
            html +=
                '<tr>' +
                '<td>' + sal.id.fromDate + '</td>' +
                '<td>' + sal.toDate + '</td>' +
                '<td>' + sal.salary + '</td>' +
                '</tr>';
        });

        html += '</table>';

        $('#app-container').html(html);
    });
}