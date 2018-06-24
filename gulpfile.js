import gulp from 'gulp'
import connect from 'gulp-connect'
import run from 'gulp-run-command'

gulp.task('build-api', run('maven build'));

gulp.task('localhost', function() {
    connect.server();
});


  