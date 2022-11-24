
function power(x, p, mod_) {
    let result = 1
    for (let i = 0; i < p; ++i) {
        result = (result * x) % mod_
    }
    return result
}

function generateKeys(G, P, a, b) {
    let x = power(G, a, P)
    let y = power(G, b, P)
    let ka = power(y, a, P)
    let kb = power(x, b, P)
    return [ka, kb]
}

function displayKeys() {
    let G = document.getElementById('G').value
    let P = document.getElementById('P').value
    let a = document.getElementById('a').value
    let b = document.getElementById('b').value
    let [ka, kb] = generateKeys(+G, +P, +a, +b)
    document.getElementById('key-1').innerText = `Secret key-1 : ${ka}`
    document.getElementById('key-2').innerText = `Secret key-2 : ${kb}`
}
