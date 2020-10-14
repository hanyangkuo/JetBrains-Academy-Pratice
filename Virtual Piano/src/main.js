let path = document.location.pathname;
let directory = path.substring(path.indexOf('/'), path.lastIndexOf('/'));

document.addEventListener("keydown", function(event){
    play(event.key.toUpperCase());
});

function play(key){
    console.log(`The ${event.key.toUpperCase()} key is pressed.`);
    let audio = new Audio(`${directory}/../resources/${event.key.toUpperCase()}.mp3`);
    audio.play();
}