function showBlogs() {
    $.ajax({
        url: 'http://localhost:8080/blog',
        type: 'get',
        success: (data) => {
            let listBlog = '';
            for (const element of data) {
              listBlog +=`
                    <h1>${element.nameBlog}</h1>
                    <p>${element.writer}</p>
                    <span>${element.postDate}</span>
                    <p>${element.content}</p>
              `
            }
            $("#list").html(listBlog);
        },
        error: () => {
            alert("hệ thống đang bảo trì");
        }
    });
    event.preventDefault();
}


function submitSearch() {
    let nameSearch = $('#search').val();
    $.ajax({
        url: 'http://localhost:8080/blog/search?word=' + nameSearch,
        type: 'get',
        success: (data) => {
            let listBlog = '';
            for (const element of data) {
              listBlog +=`
                    <h1>${element.nameBlog}</h1>
                    <span>${element.writer}</span>
                    <span>${element.postDate}</span>
                    <p>${element.content}</p>
              `
            }
            $("#list").html(listBlog);
        },
        error: () => {
            alert("hệ thống đang bảo trì");
        }
    });
    event.preventDefault();
}
let page = 0;
function loadBlog() {
    page++;
        $.ajax({
            url: 'http://localhost:8080/blog?page=' + (page),
            type: 'GET',
            success: (data) => {
                let listBlog = '';
            for (const element of data.content) {
              listBlog +=`
                    <h1>${element.nameBlog}</h1>
                    <span>${element.writer}</span>
                    <span>${element.postDate}</span>
                    <p>${element.content}</p>
              `
            }
            $("#list").html(listBlog);
            },
            error: (event) => {
                console.log(event);
            }
        });
        event.preventDefault();
}