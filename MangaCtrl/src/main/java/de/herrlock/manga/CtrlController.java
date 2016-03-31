package de.herrlock.manga;

import static de.herrlock.manga.util.Execs.ADD_TO_JD_W_FILE;
import static de.herrlock.manga.util.Execs.DIALOG_DOWNLOADER;
import static de.herrlock.manga.util.Execs.PLAIN_DOWNLOADER;
import static de.herrlock.manga.util.Execs.PRINT_ALL_HOSTER;
import static de.herrlock.manga.util.Execs.START_SERVER;
import static de.herrlock.manga.util.Execs.VIEW_PAGE_MAIN;

import de.herrlock.javafx.handler.Exec;
import de.herrlock.javafx.handler.ExecHandlerTask;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public final class CtrlController {

    @FXML
    public Text runningText, bottomText;
    @FXML
    public Button btnStartDDL, btnStartPDL, btnStartServer, btnShowHosts, btnCreateHTML;

    public void clearText() {
        this.bottomText.setText( "" );
    }

    public void showTextDStart() {
        setBottomText( "button.tooltip.startDDL" );
    }
    public void showTextPStart() {
        setBottomText( "button.tooltip.startPDL" );
    }
    public void showTextServerStart() {
        setBottomText( "button.tooltip.startServer" );
    }
    public void showTextHosts() {
        setBottomText( "button.tooltip.showHosts" );
    }
    public void showTextJD() {
        setBottomText( "button.tooltip.addToJD" );
    }
    public void showTextHTML() {
        setBottomText( "button.tooltip.createHTML" );
    }
    private void setBottomText( final String i18nKey ) {
        this.bottomText.setText( Ctrl.I18N.getString( i18nKey ) );
    }

    public void startDDownload() {
        handleBtnClick( DIALOG_DOWNLOADER );
    }
    public void startPDownload() {
        handleBtnClick( PLAIN_DOWNLOADER );
    }
    public void startServer() {
        handleBtnClick( START_SERVER, false );
    }
    public void showHosts() {
        handleBtnClick( PRINT_ALL_HOSTER );
    }
    public void exportToJd() {
        handleBtnClick( ADD_TO_JD_W_FILE );
    }
    public void createHtml() {
        handleBtnClick( VIEW_PAGE_MAIN );
    }

    public void handleBtnClick( final Exec exec ) {
        handleBtnClick( exec, true );
    }

    public void handleBtnClick( final Exec exec, final boolean daemon ) {
        this.btnStartDDL.setOnAction( null );
        this.btnStartPDL.setOnAction( null );
        this.btnStartServer.setOnAction( null );
        this.btnShowHosts.setOnAction( null );
        this.btnCreateHTML.setOnAction( null );

        Thread thread = new Thread( new ExecCtrlHandlerTask( exec ) );
        thread.setDaemon( daemon );
        thread.start();
    }

    final class ExecCtrlHandlerTask extends ExecHandlerTask {
        public ExecCtrlHandlerTask( final Exec exec ) {
            super( exec );
        }

        @Override
        protected Void call() {
            CtrlController.this.runningText.setVisible( true );
            return super.call();
        }
    }
}
