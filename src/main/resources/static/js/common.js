function getQueryString(name) {
    let reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    let r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return unescape(r[2]);
    }

    return null;
}

function bbsParseDate(sqlDate) {
    let year = sqlDate.substring(0, 4);
    let month = sqlDate.substring(5, 7);
    let date = sqlDate.substring(8, 10);
    let hour = sqlDate.substring(11, 13);
    let minute = sqlDate.substring(14, 16);
    let second = sqlDate.substring(17, 19);

    return "" + year + "-" + month + "-" + date + "&nbsp;" + hour + ":" + minute + ":" + second;
}