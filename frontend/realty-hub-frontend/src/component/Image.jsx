import React from "react";

const Image = ({build}) => {
    if(build !== null && build !== undefined) {
        return (
            <div>
                {build.map(item => (
                    <img id="ItemPreview" src = {"data:image/png;base64," + item.bytes} alt="name"/>
                ))}
            </div>
        )
    }
}
export default Image;