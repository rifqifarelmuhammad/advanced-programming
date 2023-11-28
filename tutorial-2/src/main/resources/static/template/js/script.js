let isPaused = false;

$(document).ready(function(){
    const list = $('#process');
    const reg = $("#iklanRegular");
    const dlx = $("#iklanDeluxe");

    let processCounter = 0;
    let currProcess
    const intervalList = setInterval(function () {
        if (!isPaused) {
            currProcess = list.children().eq(processCounter).children();
            if (currProcess.children('div[id^="iklan"]').length) {
                $('#spinner').css('display', 'none');
                console.log("Showing Ad");
                isPaused = true;
                if (reg.length) {
                    showAd(reg, '#CDRegular');
                } else if (dlx.length) {
                    showAd(dlx, '#CDDeluxe');
                }
            }

            if (currProcess.text() === "Light turned on") {
                document.documentElement.setAttribute('data-bs-theme', 'light');
            } else if (currProcess.text() === "Light turned off") {
                document.documentElement.setAttribute('data-bs-theme', 'dark');
            }

            if (currProcess.text().toString().includes("Playing")) {
                let txt = currProcess.text().toString();
                let imgSource = `../img/${txt.charAt(txt.length - 3)}HD.png`
                currProcess.append(`<br><img src=${imgSource} height="400px">`)
            }

            console.log(currProcess.text());
            list.children().eq(processCounter++).css('display', 'block');

            if (processCounter >= list.children().length) {
                $('#spinner').css('display', 'none');
                clearInterval(intervalList);
            }
        }
    }, 3000);
});

function showMovie(modal) {
    modal.modal('show');
    let counter = 10
    const intervalMovie = setInterval(function () {
        if (--counter === 0) {
            modal.modal('hide');
            isPaused = false;
            clearInterval(intervalMovie);
        }
    }, 1000);
}

function showAd(modal, cooldown) {
    modal.modal('show');
    let counter = $(cooldown).text()
    const intervalAd = setInterval(function () {
        $(cooldown).text(--counter);
        if (counter === 0) {
            modal.modal('hide');
            $('#spinner').css('display', 'block');
            isPaused = false;
            clearInterval(intervalAd);
        }
    }, 1000);
}