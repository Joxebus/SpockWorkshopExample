package com.nearsoft.util

String MAIN_DIR = '/Users/obautista/Documents/workspace-public/GrailsWorkshop'

new File(MAIN_DIR).eachFileRecurse { dir ->
    if(dir.isDirectory()){
        if(!dir.list()){
            def out = new File(dir, 'PLACEHOLDER').newPrintWriter()
            out.println('PLACEHOLDER')
            out.close()

        }

    }

}
