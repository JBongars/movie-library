const gulp = require('gulp');
const connect = require('gulp-connect');
const run = require('gulp-run-command');

//gulp.task('build-api', run('maven build'));

gulp.task('localhost', function() {
    connect.server();
});


  