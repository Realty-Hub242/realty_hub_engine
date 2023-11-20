import React from "react";

const Image = ({build}) => {
    if(build !== null && build !== undefined) {
        return (
            <div>
                <img id="ItemPreview" src = {"data:image/png;base64," + build.bytes} alt="name"/>
            </div>
        )
    }
}
export default Image;