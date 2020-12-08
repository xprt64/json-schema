var fs = require('fs');
var path = require('path');
var schemas = require('json-schema-to-typescript');
var walk = function (dir, done) {
    var results = [];
    fs.readdir(dir, function (err, list) {
        if (err) return done(err);
        var i = 0;
        (function next() {
            var file = list[i++];
            if (!file) return done(null, results);
            file = path.resolve(dir, file);
            fs.stat(file, function (err, stat) {
                if (stat && stat.isDirectory()) {
                    walk(file, function (err, res) {
                        results = results.concat(res);
                        next();
                    });
                } else {
                    results.push(file);
                    next();
                }
            });
        })();
    });
};

const schemasDir  = process.cwd() + '/schemas';
const outputDir = process.cwd() + '/schemas.ts';
 
walk(schemasDir, function (err, results) {
    if (err) throw err;

     !fs.existsSync(outputDir) && fs.mkdirSync(outputDir);

    results = results
        .filter(file => file.endsWith('.json'))
    console.log(results);
    results
        .forEach(file => {
            schemas
                .compileFromFile(file, {
                    bannerComment: `/** ${file}  */`,
                    declareExternallyReferenced: true,
                    unreachableDefinitions: true,
                    enableConstEnums: true
                })
                .then(code => fs.writeFileSync(outputDir + '/' + justName(file) + '.d.ts', code))
        })
});

function justName(pathS) {
    return path.basename(pathS, '.schema.json')
}


